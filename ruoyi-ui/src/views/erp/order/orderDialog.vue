<template>
  <!-- 添加或修改库存销售订单对话框 -->
  <el-dialog :title="title" :visible.sync="visible" width="1000px" @close="$emit('close')" append-to-body>
    <el-card lass="box-card">
      <div slot="header" class="clearfix">
        <span>基础信息</span>
        <!-- <el-button style="float: right; padding: 3px 0" type="text">确认</el-button> -->
        <!-- <el-button style="float: right; padding: 3px 0" type="text">编辑</el-button> -->
      </div>

      <el-form ref="form" :inline="true" :model="form" :rules="rules" label-width="80px" style="display: flex; justify-content: space-evenly;">
        <el-form-item label="客户姓名" prop="clientNickname" label-width="auto">
          <el-input v-model="form.clientName" placeholder="请输入客户姓名" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="客户手机号" prop="clientMobile" label-width="auto">
          <el-input v-model="form.clientName" placeholder="请输入客户手机号" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="送货地址" prop="shppingAddress" label-width="auto">
          <el-input v-model="form.clientName" placeholder="请输入送货地址" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="开票" label-width="auto">
          <el-switch v-model="form.taxNeed"></el-switch>
        </el-form-item>
      </el-form>
    </el-card>

    <div style="margin-top: 50px"></div>
    
    <transition name="fade">
      <el-card lass="box-card" v-show="form.taxNeed">
        <div slot="header" class="clearfix">
          <span>开票信息</span>
          <!-- <el-button style="float: right; padding: 3px 0" type="text">确认</el-button> -->
          <!-- <el-button style="float: right; padding: 3px 0" type="text">编辑</el-button> -->
        </div>

        <el-form ref="form" :inline="true" :model="form" :rules="rules" label-width="auto">
          <el-row type="flex" justify="space-between">
            <el-col :span="8">
              <el-form-item label="纳税人识别号" prop="taxpayerId">
                <el-input size="mini" v-model="form.clientName" placeholder="请输入纳税人识别号"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="公司名称" prop="companyName">
                <el-input size="mini" v-model="form.clientName" placeholder="请输入公司名称"></el-input>
              </el-form-item>              
            </el-col>
            <el-col :span="8">
              <el-form-item label="公司地址" prop="companyAddress">
                <el-input size="mini" v-model="form.clientName" placeholder="请输入公司地址"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          
          <el-row type="flex" justify="space-between">
            <el-col :span="8">
              <el-form-item label="联系电话" prop="contactTel">
                <el-input size="mini" v-model="form.clientName" placeholder="请输入联系电话"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="银行账户" prop="bankAccount" label-width="auto">
                <el-input size="mini" v-model="form.clientName" placeholder="请输入银行账户"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="开户行" prop="deposit_bank" label-width="auto">
                <el-input size="mini" v-model="form.clientName" placeholder="请输入开户行"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

        </el-form>
      </el-card>
    </transition>
    
    <div style="margin-top: 50px"></div>

    <el-card lass="box-card">
      <div slot="header" class="clearfix">
        <span>产品清单</span>
        <!-- <el-button style="float: right; padding: 3px 0" type="text">确认</el-button> -->
        <!-- <el-button style="float: right; padding: 3px 0" type="text">编辑</el-button> -->
      </div>

      <el-form label-position="left" ref="form" :inline="true" :model="form" :rules="rules" label-width="80px" style="display: flex; justify-content: space-evenly;">
        <el-form-item label="产品名称" prop="productName" label-width="auto">
          <el-input v-model="form.clientName" placeholder="请输入产品名称" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="产品型号" prop="productModel" label-width="auto">
          <el-input v-model="form.clientName" placeholder="请输入产品型号" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="产品数量" prop="productAmount" label-width="auto">
          <el-input v-model="form.clientName" placeholder="请输入产品数量" size="mini"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            type="primary"
            plain
            icon="el-icon-plus"
            size="mini"
            @click="handleAdd"
            v-hasPermi="['erp:order:add']"
          >新增</el-button>
        </el-form-item>
      </el-form>

      <el-table v-loading="loading" :data="productList">
        <el-table-column align="center" label="名称" prop="productName"></el-table-column>
        <el-table-column align="center" label="型号" prop="productModel"></el-table-column>
        <el-table-column align="center" label="数量" prop="productAmount"></el-table-column>
        <el-table-column align="center" label="金额" prop="productPrice"></el-table-column>
          <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
            <el-button type="text" size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitForm">确 定</el-button>
      <el-button @click="$emit('close')">取 消</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: "order-dialog",
  props: ['visible', 'title', 'edit'],
  data() {
    return {
      // 产品清单表格数据
      productList: [],
      // 表单参数
      form: {
        taxNeed: false
      }
    }
  },
  watch: {
    visible(val, oldVal) {
      console.log(val)
    }
  }
}
</script>

<style>

</style>