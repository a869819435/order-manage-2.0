<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      :inline="true"
      v-show="showSearch"
      label-width="85px"
    >
      <!-- <el-form-item label="技能编码" prop="skillId">
        <el-input
          v-model="queryParams.skillId"
          placeholder="请输入技能编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="技能名称" prop="skillName">
        <el-input
          v-model="queryParams.skillName"
          placeholder="请输入技能名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="技能熟练度" prop="skillLevel">
        <el-input
          v-model="queryParams.skillLevel"
          placeholder="请输入技能熟练度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="技能拥有人" prop="skillerInfo">
        <el-input
          v-model="queryParams.skillerInfo"
          placeholder="请输入技能拥有人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
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
          v-hasPermi="['skill:skiiUser:add']"
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
          v-hasPermi="['skill:skiiUser:edit']"
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
          v-hasPermi="['skill:skiiUser:remove']"
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
          v-hasPermi="['skill:skiiUser:export']"
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
      :data="skiiUserList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键" align="center" prop="id" /> -->
      <el-table-column label="技能编号" align="center" prop="skillId" />
      <el-table-column label="技能名称" align="center" prop="skillName" />
      <el-table-column label="技能熟练度" align="center" prop="skillLevel" />
      <el-table-column label="技能拥有人" align="center" prop="skillerInfo" />
      <el-table-column
        label="状态"
        align="center"
        prop="status"
        :formatter="statusFormat"
      />
      <el-table-column label="描述" align="center" prop="remark" />
      <!-- <el-table-column label="是否删除" align="center" prop="isDeleted" /> -->
      <el-table-column label="创建人id" align="center" prop="createUserName" />
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
      <el-table-column label="修改人id" align="center" prop="updateUserName" />
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
            v-hasPermi="['skill:skiiUser:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['skill:skiiUser:remove']"
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

    <!-- 添加或修改技能-技师信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="620px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="技能主键" prop="skillId">
          <!-- <el-input v-model="form.skillId" placeholder="请选择技能主键" /> -->
          <el-select
            filterable
            v-model="form.skillId"
            placeholder="请选择技师"
            clearable
            style="width: 460px"
            @change="clickSkillOptions()"
          >
            <el-option
              v-for="item in skillOptions"
              :key="item.value"
              :label="item.value"
              :value="item.value"
              >{{ item.value + "(" + item.name + ")" }}
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="技能名称" prop="skillName">
          <el-input
            v-model="form.skillName"
            placeholder="请选择技能主键"
            :value="form.skillName"
            disabled
          />
        </el-form-item>
        <el-form-item label="技能熟练度" prop="skillLevel">
          <el-input v-model="form.skillLevel" placeholder="请输入技能熟练度" />
        </el-form-item>
        <el-form-item label="技能拥有人" prop="skillerId">
          <el-select
            filterable
            v-model="form.skillerId"
            placeholder="请选择技师"
            clearable
            style="width: 460px"
          >
            <el-option
              v-for="item in skillerOptions"
              :key="item.value"
              :label="item.name"
              :value="item.value"
              >{{ item.name }}
            </el-option>
          </el-select>
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
  listSkiiUser,
  getSkiiUser,
  delSkiiUser,
  addSkiiUser,
  updateSkiiUser,
  exportSkiiUser,
} from "@/api/skill/skiiUser";
import { listInfo } from "@/api/skill/info";
import { listSkiller } from "@/api/skill/skiller";

export default {
  name: "SkiiUser",
  components: {},
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
      // 技能-技师信息表格数据
      skiiUserList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 技师下拉选项
      skillerOptions: [],
      // 技能下拉选项
      skillOptions: [],
      // 状态字典
      statusOptions: [],
      // 创建时间时间范围
      daterangeCreateDate: [],
      // 修改时间时间范围
      daterangeUpdateDate: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        skillId: null,
        skillName: null,
        skillLevel: null,
        skillerId: null,
        status: null,
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
        skillId: [
          { required: true, message: "技能主键不能为空", trigger: "blur" },
        ],
        skillName: [
          { required: true, message: "技能名称不能为空", trigger: "blur" },
        ],
        skillLevel: [
          { required: true, message: "技能熟练度不能为空", trigger: "blur" },
        ],
        skillerId: [
          { required: true, message: "技能拥有人不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getList();
    this.getDicts("general_status").then((response) => {
      this.statusOptions = response.data;
    });
  },
  methods: {
    /** 查询技能-技师信息列表 */
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
      listSkiiUser(this.queryParams).then((response) => {
        this.skiiUserList = response.rows;
        this.total = response.total;
        this.loading = false;
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
        skillId: null,
        skillName: null,
        skillLevel: null,
        skillerId: null,
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
      this.getSkillList();
      this.getSkillerList();
      this.open = true;
      this.title = "添加技能-技师信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getSkillList();
      this.getSkillerList();
      const id = row.id || this.ids;
      getSkiiUser(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改技能-技师信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateSkiiUser(this.form).then((response) => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSkiiUser(this.form).then((response) => {
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
        '是否确认删除技能-技师信息编号为"' + ids + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }
      )
        .then(function () {
          return delSkiiUser(ids);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm("是否确认导出所有技能-技师信息数据项?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return exportSkiiUser(queryParams);
        })
        .then((response) => {
          this.download(response.msg);
        });
    },
    // 获取技师列表
    getSkillerList() {
      listSkiller().then((response) => {
        this.skillerOptions = [];
        let array = response.rows;
        for (let index = 0; index < array.length; index++) {
          const data = array[index];
          this.skillerOptions.push({ value: data.id, name: data.userInfo });
        }
      });
    },
    // 获取技能列表
    getSkillList() {
      listInfo().then((response) => {
        this.skillOptions = [];
        let array = response.rows;
        for (let index = 0; index < array.length; index++) {
          const data = array[index];
          this.skillOptions.push({ value: data.id, name: data.name });
        }
      });
    },
    // 技能下拉选择点击事件
    clickSkillOptions() {
      const temp = this.skillOptions.find(
        (item) => item.value === this.form.skillId
      );
      this.form.skillName = temp.name;
    },
  },
};
</script>
