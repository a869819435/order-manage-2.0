<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="地址编码" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入地址编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入地址名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="经度" prop="longitude">
        <el-input
          v-model="queryParams.longitude"
          placeholder="请输入经度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="维度" prop="dimension">
        <el-input
          v-model="queryParams.dimension"
          placeholder="请输入维度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="地址分类" prop="classId">
        <!-- <el-input
          v-model="queryParams.classId"
          placeholder="请选择地址分类"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        /> -->
        <treeselect
          v-model="queryParams.classId"
          :options="addressOptions"
          :normalizer="normalizer"
          placeholder="请选择地址分类"
          style="width: 250px"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select
          v-model="queryParams.status"
          placeholder="请选择状态"
          clearable
          size="small"
        >
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="创建人id" prop="createUser">
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
          v-hasPermi="['address:info:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['address:info:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['address:info:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['address:info:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="infoList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="地址编码" align="center" prop="code" />
      <el-table-column label="地址名称" align="center" prop="name" />
      <el-table-column label="经度" align="center" prop="longitude" />
      <el-table-column label="维度" align="center" prop="dimension" />
      <el-table-column label="地址分类" align="center" prop="classId" />
      <el-table-column
        label="状态"
        align="center"
        prop="status"
        :formatter="statusFormat"
      />
      <el-table-column label="描述" align="center" prop="remark" />
      <el-table-column label="创建人" align="center" prop="createUserName" />
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
      <el-table-column label="修改人" align="center" prop="updateUserName" />
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
            v-hasPermi="['address:info:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['address:info:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改地址经纬度信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="620px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <!-- <el-form-item label="地址编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入地址编码" />
        </el-form-item> -->
        <el-form-item label="地址名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入地址名称" />
        </el-form-item>
        <el-form-item label="经度" prop="longitude">
          <el-input v-model="form.longitude" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="维度" prop="dimension">
          <el-input v-model="form.dimension" placeholder="请输入维度" />
        </el-form-item>
        <el-form-item label="地址分类" prop="classId">
          <!-- <el-input v-model="form.classId" placeholder="请输入地址分类id" /> -->
          <!-- 
            :disable-branch-nodes="true" 只能选择最后一级的元素 
            :show-count="true" 显示子类下的个数
          -->
          <treeselect
            v-model="form.classId"
            :options="addressOptions"
            :normalizer="normalizer"
            :show-count="true"
            :disable-branch-nodes="true"
            placeholder="请选择地址分类"
          />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in statusOptions"
              :key="dict.dictValue"
              :label="parseInt(dict.dictValue)"
              >{{ dict.dictLabel }}</el-radio
            >
          </el-radio-group>
        </el-form-item>
        <el-form-item label="描述" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入描述" />
        </el-form-item>
        <!-- <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
        </el-form-item>
        <el-form-item label="创建人id" prop="createUser">
          <el-input v-model="form.createUser" placeholder="请输入创建人id" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createDate">
          <el-date-picker clearable size="small"
            v-model="form.createDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改人id" prop="updateUser">
          <el-input v-model="form.updateUser" placeholder="请输入修改人id" />
        </el-form-item>
        <el-form-item label="修改时间" prop="updateDate">
          <el-date-picker clearable size="small"
            v-model="form.updateDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择修改时间">
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
  listInfo,
  getInfo,
  delInfo,
  addInfo,
  updateInfo,
  exportInfo,
} from "@/api/address/info";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import { listAddress } from "@/api/classify/address";

export default {
  name: "Info",
  components: {
    Treeselect,
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 地址经纬度信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态字典
      statusOptions: [],
      // 地址分类树选项
      addressOptions: [],
      // 创建时间时间范围
      daterangeCreateDate: [],
      // 修改时间时间范围
      daterangeUpdateDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        code: null,
        name: null,
        longitude: null,
        dimension: null,
        classId: null,
        status: null,
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
          { required: true, message: "地址编码不能为空", trigger: "blur" },
        ],
        name: [
          { required: true, message: "地址名称不能为空", trigger: "blur" },
        ],
        longitude: [
          { required: true, message: "经度不能为空", trigger: "blur" },
        ],
        dimension: [
          { required: true, message: "维度不能为空", trigger: "blur" },
        ],
        classId: [
          { required: true, message: "地址分类id不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
    this.getTreeselect();
    this.getDicts("general_status").then((response) => {
      this.statusOptions = response.data;
    });
  },
  methods: {
    /** 查询地址经纬度信息列表 */
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
      listInfo(this.queryParams).then((response) => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 转换地址分类数据结构 */
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
    /** 查询部门下拉树结构 */
    getTreeselect() {
      listAddress().then((response) => {
        this.addressOptions = [];
        const data = { id: 0, name: "顶级节点", children: [], level: 0 };
        data.children = this.handleTree(response.data, "id", "parentId");
        this.addressOptions.push(data);
      });
    },
    // 状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
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
        longitude: null,
        dimension: null,
        classId: null,
        status: 0,
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
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCreateDate = [];
      this.daterangeUpdateDate = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getTreeselect();
      this.open = true;
      this.title = "添加地址经纬度信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getTreeselect();
      const id = row.id || this.ids;
      getInfo(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地址经纬度信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then((response) => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then((response) => {
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
      const ids = row.id || this.ids;
      this.$confirm(
        '是否确认删除地址经纬度信息编号为"' + ids + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(function () {
          return delInfo(ids);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm("是否确认导出所有地址经纬度信息数据项?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return exportInfo(queryParams);
        })
        .then((response) => {
          this.download(response.msg);
        });
    },
  },
};
</script>
