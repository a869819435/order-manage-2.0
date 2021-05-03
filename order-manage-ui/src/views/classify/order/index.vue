<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      :inline="true"
      v-show="showSearch"
      label-width="96px"
    >
      <el-form-item label="工单分类编码" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入工单分类编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工单分类名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入工单分类名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="父级分类" prop="parentId">
        <!-- <el-input
          v-model="queryParams.parentId"
          placeholder="请输入父级分类"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        /> -->
        <treeselect
          v-model="queryParams.parentId"
          :options="orderOptions"
          :normalizer="normalizer"
          placeholder="请选择父级分类"
          style="width: 250px"
        />
      </el-form-item>
      <el-form-item label="层级" prop="level">
        <!-- <el-input
          v-model="queryParams.level"
          placeholder="请输入层级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        /> -->
        <el-select
          v-model="queryParams.level"
          placeholder="请输入层级"
          clearable
          size="small"
        >
          <el-option
            v-for="dict in levelOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
            >{{ dict.dictLabel }}</el-option
          >
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="是否删除" prop="isDeleted">
        <el-input
          v-model="queryParams.isDeleted"
          placeholder="请输入是否删除"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人id" prop="createUser">
        <el-input
          v-model="queryParams.createUser"
          placeholder="请输入创建人id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="daterangeCreateDate"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="修改人id" prop="updateUser">
        <el-input
          v-model="queryParams.updateUser"
          placeholder="请输入修改人id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改时间">
        <el-date-picker
          v-model="daterangeUpdateDate"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item> -->
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['classify:order:add']"
          >新增</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="orderList"
      row-key="id"
      :load="loadTree"
      lazy
      :default-expand-all="false"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column label="工单分类编码" align="left" prop="code" />
      <el-table-column label="工单分类名称" align="center" prop="name" />
      <el-table-column label="父级分类" align="center" prop="parentId" />
      <el-table-column
        label="层级"
        align="center"
        prop="level"
        :formatter="levelFormat"
      />
      <el-table-column label="备注" align="center" prop="remark" />
      <!-- <el-table-column label="是否删除" align="center" prop="isDeleted" /> -->
      <el-table-column label="创建人id" align="center" prop="createUser" />
      <el-table-column
        label="创建时间"
        align="center"
        prop="createDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createDate, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改人id" align="center" prop="updateUser" />
      <el-table-column
        label="修改时间"
        align="center"
        prop="updateDate"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateDate, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['classify:order:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['classify:order:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改工单分类对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="620px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="工单分类编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入工单分类编码" />
        </el-form-item>
        <el-form-item label="工单分类名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入工单分类名称" />
        </el-form-item>
        <el-form-item label="父级分类" prop="parentId">
          <treeselect
            v-model="form.parentId"
            :options="orderOptions"
            :normalizer="normalizer"
            placeholder="请选择父级分类"
          />
        </el-form-item>
        <el-form-item label="层级" prop="level">
          <!-- <el-input v-model="form.level" placeholder="请输入层级" /> -->
          <el-select
            v-model="form.level"
            placeholder="请输入层级"
            clearable
            style="width: 100%"
          >
            <el-option
              v-for="dict in levelOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
              >{{ dict.dictLabel }}</el-option
            >
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <!-- <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
        </el-form-item>
        <el-form-item label="创建人id" prop="createUser">
          <el-input v-model="form.createUser" placeholder="请输入创建人id" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createDate">
          <el-date-picker
            clearable
            size="small"
            v-model="form.createDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择创建时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改人id" prop="updateUser">
          <el-input v-model="form.updateUser" placeholder="请输入修改人id" />
        </el-form-item>
        <el-form-item label="修改时间" prop="updateDate">
          <el-date-picker
            clearable
            size="small"
            v-model="form.updateDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择修改时间"
          >
          </el-date-picker>
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listOrder,
  getOrder,
  delOrder,
  addOrder,
  updateOrder,
  exportOrder,
} from "@/api/classify/order";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Order",
  components: {
    Treeselect,
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 工单分类表格数据
      orderList: [],
      // 层级字典类型
      levelOptions: [],
      // 工单分类树选项
      orderOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 创建时间时间范围
      daterangeCreateDate: [],
      // 修改时间时间范围
      daterangeUpdateDate: [],
      // 树对象
      mapTree: new Map(),
      // 查询参数
      queryParams: {
        code: null,
        name: null,
        parentId: null,
        level: null,
        isDeleted: null,
        createUser: null,
        createDate: null,
        updateUser: null,
        updateDate: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        code: [
          { required: true, message: "工单分类编码不能为空", trigger: "blur" },
        ],
        name: [
          { required: true, message: "工单分类名称不能为空", trigger: "blur" },
        ],
        parentId: [
          { required: true, message: "父级分类不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
    this.getTreeselect();
    this.getDicts("class_level").then((response) => {
      this.levelOptions = response.data;
    });
  },
  // 重新触发树形表格的loadTree函数(因项目中需要多次触发loadTree方法，故封装成一个方法)
  refreshLoadTree(parentId) {
    // 根据父级id取出对应节点数据
    const { tree, treeNode, resolve } = this.mapTree.get(parentId);
    this.$set(
      this.$refs.multipleTable.store.states.lazyTreeNodeMap,
      parentId,
      []
    );
    if (tree) {
      this.loadTree(tree, treeNode, resolve);
    }
  },
  methods: {
    /** 查询工单分类列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreateDate && "" != this.daterangeCreateDate) {
        this.queryParams.params[
          "beginCreateDate"
        ] = this.daterangeCreateDate[0];
        this.queryParams.params["endCreateDate"] = this.daterangeCreateDate[1];
      }
      if (null != this.daterangeUpdateDate && "" != this.daterangeUpdateDate) {
        this.queryParams.params[
          "beginUpdateDate"
        ] = this.daterangeUpdateDate[0];
        this.queryParams.params["endUpdateDate"] = this.daterangeUpdateDate[1];
      }
      listOrder(this.queryParams).then((response) => {
        this.orderList = this.handleTree(response.data, "id", "parentId");
        this.loading = false;
      });
    },
    // 层级字典翻译
    levelFormat(row, column) {
      return this.selectDictLabel(this.levelOptions, row.level);
    },
    /** 转换工单分类数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.id,
        label: node.name,
        children: node.children,
      };
    },
    /** 查询工单下拉树结构 */
    getTreeselect() {
      listOrder().then((response) => {
        this.orderOptions = [];
        const data = { id: 0, name: "顶级节点", children: [] };
        data.children = this.handleTree(response.data, "id", "parentId");
        this.orderOptions.push(data);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        code: null,
        name: null,
        parentId: null,
        level: null,
        remark: null,
        isDeleted: null,
        createUser: null,
        createDate: null,
        updateUser: null,
        updateDate: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCreateDate = [];
      this.daterangeUpdateDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getTreeselect();
      this.open = true;
      this.title = "添加工单分类";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getTreeselect();
      if (row != null) {
        this.form.parentId = row.id;
      }
      getOrder(row.id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工单分类";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateOrder(this.form).then((response) => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrder(this.form).then((response) => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      this.$confirm(
        '是否确认删除工单分类编号为"' + row.id + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(function () {
          return delOrder(row.id);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    },
    loadTree(tree, treeNode, resolve) {
      // 将当前选中节点数据存储到map中
      this.mapTree.set(tree.id, { tree, treeNode, resolve });
      try {
        // 根据实际项目发送ajax获取数据
        getGoodsCategorys({
          parentId: tree.id,
        }).then((res) => {
          const nodes = res.data.map((item) => {
            return {
              ...item,
              // 该数据有三级结构
              hasChildren: item.level <= 3,
            };
          });
          resolve(nodes);
        });
      } catch (error) {
        return error;
      }
    },
  },
};
</script>
