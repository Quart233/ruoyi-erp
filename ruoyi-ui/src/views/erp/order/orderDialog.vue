<template>
  <!-- 添加或修改库存销售订单对话框 -->
  <el-dialog :title="title" :visible.sync="visible" width="1000px" @close="$emit('close')" append-to-body>
    <el-card lass="box-card">
      <div slot="header" class="clearfix">
        <span>基础信息</span>
        <!-- <el-button style="float: right; padding: 3px 0" type="text">确认</el-button> -->
        <!-- <el-button style="float: right; padding: 3px 0" type="text">编辑</el-button> -->
      </div>

      <el-form ref="form" :inline="true" :model="form" :rules="rules" label-width="80px">
        <el-row type="flex" justify="space-between">
          <el-col :span="6">
            <el-form-item label="客户姓名" prop="clientNickname" label-width="auto">
              <el-autocomplete
                v-model="form.clientNickname" 
                :fetch-suggestions="queryClientNameAsync" 
                placeholder="请输入客户姓名"
                @select="handleSelect"
                size="mini"
                :trigger-on-focus="false"
              ></el-autocomplete>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="客户手机号" prop="clientPhone" label-width="auto">
              <el-input v-model="form.clientPhone" placeholder="请输入客户手机号" size="mini"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="送货地址" prop="shippingAddress" label-width="auto">
              <el-input v-model="form.shippingAddress" placeholder="请输入送货地址" size="mini" max="100" style="width:218px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="实付金额" prop="actualPayment" label-width="auto">
              <el-input size="mini" v-model="form.actualPayment" placeholder="请输入实付金额"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row type="flex" justify="space-between">
          <el-col :span="6">
            <el-form-item label="创建时间" prop="createTime" label-width="auto">
              <el-date-picker v-model="form.createTime" type="datetime" placeholder="选择日期时间" size="mini" style="width: 189px"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="经手人" prop="handlerName" label-width="auto">
              <el-input size="mini" v-model="form.handlerName" placeholder="请输入经手人"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="订单备注" prop="remark" label-width="auto">
              <el-input size="mini" v-model="form.remark" placeholder="请输入备注"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="开票" label-width="auto" style="display: flex; flex-direction: column;">
              <el-switch v-model="form.taxNeed"></el-switch>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </el-card>

    <div style="margin-top: 10px"></div>
    
    <transition name="fade">
      <el-card lass="box-card" v-show="form.taxNeed">
        <div slot="header" class="clearfix">
          <span>开票信息</span>
          <!-- <el-button style="float: right; padding: 3px 0" type="text">确认</el-button> -->
          <!-- <el-button style="float: right; padding: 3px 0" type="text">编辑</el-button> -->
        </div>

        <el-form ref="form" :inline="true" :model="taxInfo" :rules="rules" label-width="auto">
          <el-row type="flex" justify="space-between">
            <el-col :span="8">
              <el-form-item label="纳税人识别号" prop="taxpayerId">
                <el-input size="mini" v-model="taxInfo.taxpayerId" placeholder="请输入纳税人识别号"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="公司名称" prop="companyName">
                <el-input size="mini" v-model="taxInfo.companyName" placeholder="请输入公司名称"></el-input>
              </el-form-item>              
            </el-col>
            <el-col :span="8">
              <el-form-item label="公司地址" prop="companyAddress">
                <el-input size="mini" v-model="taxInfo.companyAddress" placeholder="请输入公司地址"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          
          <el-row type="flex" justify="space-between">
            <el-col :span="8">
              <el-form-item label="联系电话" prop="contactTel">
                <el-input size="mini" v-model="taxInfo.contactTel" placeholder="请输入联系电话"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="银行账户" prop="bankAccount" label-width="auto">
                <el-input size="mini" v-model="taxInfo.bankAccount" placeholder="请输入银行账户"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="开户行" prop="depositBank" label-width="auto">
                <el-input size="mini" v-model="taxInfo.depositBank" placeholder="请输入开户行"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

        </el-form>
      </el-card>
    </transition>
    
    <div style="margin-top: 10px"></div>

    <el-card lass="box-card">
      <div slot="header" class="clearfix">
        <span>产品清单</span>
        <!-- <el-button style="float: right; padding: 3px 0" type="text">确认</el-button> -->
        <!-- <el-button style="float: right; padding: 3px 0" type="text">编辑</el-button> -->
      </div>

      <el-form label-position="left" ref="form" :inline="true" :model="productQueryParams" :rules="rules" label-width="80px" style="display: flex; justify-content: space-evenly;">
        <el-form-item label="产品名称" prop="productName" label-width="auto">
          <el-autocomplete
            v-model="productQueryParams.productName" 
            :fetch-suggestions="queryProductAsync" 
            placeholder="支持标签(使用空格分割)"
            :trigger-on-focus="false"
            @select="handleProductNameSelect"
            size="mini"
          ></el-autocomplete>
        </el-form-item>
        <el-form-item label="产品型号" prop="productModel" label-width="auto">
          <el-input v-model="productQueryParams.productModel" placeholder="请输入产品型号" size="mini"></el-input>
        </el-form-item>
        <el-form-item label="产品数量" prop="productAmount" label-width="auto">
          <el-input v-model="productQueryParams.productAmount" placeholder="请输入产品数量" size="mini"></el-input>
        </el-form-item>
        <!-- <el-form-item label="产品备注" prop="productRemark" label-width="auto">
          <el-input v-model="form.productRemark" placeholder="请输入产品备注" size="mini"></el-input>
        </el-form-item> -->
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
            <el-button @click="handleItemDeleteClick(scope.row)" type="text" size="small">删除</el-button>
            <el-button @click="handleItemDownClick(scope.row)" type="text" size="small">
              <i class="el-icon-arrow-down"/>
            </el-button>
            <el-button @click="handleItemUpClick(scope.row)" type="text" size="small">
              <i class="el-icon-arrow-up"/>
            </el-button>
            <!-- <el-button type="text" size="small">编辑</el-button> -->
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
import { listClient } from '@/api/erp/client'
import { querPorductByTags } from '@/api/erp/product'
import Vue from "vue"
export default {
  name: "order-dialog",
  props: ['visible', 'title', 'edit'],
  data() {
    return {
      // 产品清单表格数据
      productList: [],
      // 表单参数
      form: {
        taxNeed: false,
        createTime: null
      },
      // 开票信息
      taxInfo: {},
      // 产品查询参数
      productQueryParams: {
        productName:""
      }
    }
  },
  methods: {
    async queryProductAsync(queryString, cb) {
      let tags = queryString.split(" ").map(item => new Object({tagName: item}))
      let response = await querPorductByTags({tags: tags});
      let result = response.data.map(item => new Object({value: item.productName, info: item}))
      result.sort((a, b) => a.info.num-b.info.num)
      console.log(result)
      cb(result)
    },
    handleProductNameSelect(item) {
      console.log(item)
      this.productQueryParams.productName = item.value
      this.productQueryParams.productModel = item.info.productModel
      this.productQueryParams.productAmount = 1
      this.productQueryParams.info = item.info
    },
    async queryClientNameAsync(queryString, cb) {
      let response = await listClient({clientNickname: queryString})
      let result = response.rows.map(item => new Object({value: item.clientNickname, info: item}))
      cb(result)
    },
    handleSelect(item) {
      console.log(item)
      this.form.clientNickname = item.value
      this.form.clientPhone = item.info.clientPhone
      this.form.shippingAddress = item.info.shippingAddress
    },
    handleAdd() {
      this.productList.push(Object.assign({productAmount: this.productQueryParams.productAmount}, this.productQueryParams.info))
    },
    handleItemDeleteClick(e) {
      let index = this.productList.findIndex(item => Object.is(e, item))
      this.productList.splice(index, 1)
    },
    handleItemDownClick(e) {
      let index = this.productList.findIndex(item => Object.is(e, item))
      if (this.productList.length == 1) return
      let target = Object.assign({}, this.productList[index + 1])
      Vue.set(this.productList, index + 1, e) // 修改目标下标对象引用为当前对象
      Vue.set(this.productList, index, target) // 修改原下标对象引用为目标对象
    },
    handleItemUpClick(e) {
      let index = this.productList.findIndex(item => Object.is(e, item))
      if (this.productList.length == 1 || index == 0) return
      let target = Object.assign({}, this.productList[index - 1])
      Vue.set(this.productList, index - 1, e) // 修改目标下标对象引用为当前对象
      Vue.set(this.productList, index, target) // 修改原下标对象引用为目标对象
    }
    
  },
  watch: {
    visible: function(val, oldVal) {
      this.form.createTime = new Date();
    }
  }
}
</script>

<style>

</style>