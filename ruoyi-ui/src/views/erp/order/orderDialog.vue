<template>
  <!-- 添加或修改库存销售订单对话框 -->
  <el-dialog :title="title" :visible.sync="visible" width="1000px" @close="$emit('close')" append-to-body>
    <el-card lass="box-card">
      <div slot="header" class="clearfix">
        <span>基础信息</span>
        <el-button style="float: right; padding: 3px 0" type="text" v-show="edit">确认</el-button>
        <el-button style="float: right; padding: 3px 0" type="text" v-show="readOnly">编辑</el-button>
      </div>

      <el-form ref="form" :inline="true" :model="form" >
        <el-row type="flex" justify="space-between">
          <el-col :span="6">
            <el-form-item label="客户姓名" prop="clientNickname" label-width="auto">
              <el-autocomplete
                v-model="clientInfo.clientNickname" 
                :fetch-suggestions="queryClientNameAsync" 
                placeholder="请输入客户姓名"
                @select="handleSelect"
                size="mini"
                :trigger-on-focus="false"
                :disabled="readOnly"
              ></el-autocomplete>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="客户手机号" prop="clientPhone" label-width="auto">
              <el-input v-model="clientInfo.clientPhone" placeholder="请输入客户手机号" size="mini" :disabled="readOnly"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="送货地址" prop="shippingAddress" label-width="auto">
              <el-input v-model="clientInfo.shippingAddress" placeholder="请输入送货地址" size="mini" max="100" style="width:218px" :disabled="readOnly"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="实付金额" prop="actualPayment" label-width="auto">
              <el-input size="mini" v-model="form.actualPayment" placeholder="请输入实付金额" :disabled="readOnly"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row type="flex" justify="space-between">
          <el-col :span="6">
          <el-form-item label="订单名称" prop="orderName" label-width="auto">
            <el-input v-model="form.orderName" placeholder="请输入订单名称" size="mini" :disabled="readOnly"></el-input>
          </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="经手人" prop="handlerName" label-width="auto">
              <el-input size="mini" v-model="form.handlerName" placeholder="请输入经手人" :disabled="readOnly"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="订单备注" prop="remark" label-width="auto">
              <el-input size="mini" v-model="form.remark" placeholder="请输入备注" :disabled="readOnly"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="4">
            <el-form-item label="开票" label-width="auto" style="display: flex; flex-direction: column;">
              <el-switch v-model="form.taxNeed" :disabled="readOnly"></el-switch>
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
          <el-button style="float: right; padding: 3px 0" type="text" v-show="edit">确认</el-button>
          <el-button style="float: right; padding: 3px 0" type="text" v-show="readOnly">编辑</el-button>
        </div>

        <el-form ref="form" :inline="true" :model="taxInfo"  label-width="auto">
          <el-row type="flex" justify="space-between">
            <el-col :span="8">
              <el-form-item label="纳税人识别号" prop="taxpayerId">
                <el-input size="mini" v-model="taxInfo.taxpayerId" placeholder="请输入纳税人识别号" :disabled="readOnly"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="公司名称" prop="companyName">
                <el-input size="mini" v-model="taxInfo.companyName" placeholder="请输入公司名称" :disabled="readOnly"></el-input>
              </el-form-item>              
            </el-col>
            <el-col :span="8">
              <el-form-item label="公司地址" prop="companyAddress">
                <el-input size="mini" v-model="taxInfo.companyAddress" placeholder="请输入公司地址" :disabled="readOnly"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          
          <el-row type="flex" justify="space-between">
            <el-col :span="8">
              <el-form-item label="联系电话" prop="contactTel">
                <el-input size="mini" v-model="taxInfo.contactTel" placeholder="请输入联系电话" :disabled="readOnly"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="银行账户" prop="bankAccount" label-width="auto">
                <el-input size="mini" v-model="taxInfo.bankAccount" placeholder="请输入银行账户" :disabled="readOnly"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="开户行" prop="depositBank" label-width="auto">
                <el-input size="mini" v-model="taxInfo.depositBank" placeholder="请输入开户行" :disabled="readOnly"></el-input>
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
        <el-button style="float: right; padding: 3px 0" type="text" v-show="edit">确认</el-button>
        <el-button style="float: right; padding: 3px 0" type="text" v-show="readOnly">编辑</el-button>
      </div>

      <el-form label-position="left" ref="form" :inline="true" :model="productQueryParams"  style="display: flex; justify-content: space-evenly;" v-show="create || edit">
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
          <el-input v-model.number="productQueryParams.productAmount" placeholder="请输入产品数量" size="mini"></el-input>
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
        <el-table-column align="center" label="金额" prop="productPrice">
          <template slot-scope="scope">{{scope.row.productPrice | toFixed(2)}}</template>
        </el-table-column>
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
      <div style="margin-top: 30px"></div>
      <h2>合计：{{totalPrice | toFixed(2)}}</h2>
    </el-card>

    <div slot="footer" class="dialog-footer" v-show="edit | create">
      <el-button @click="restForm">清 除</el-button>
      <el-button type="primary" @click="submitForm">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { listClient } from '@/api/erp/client'
import { querPorductByTags } from '@/api/erp/product'
import { addOrder, getOrder } from '@/api/erp/order'
import Vue from "vue"
export default {
  name: "order-dialog",
  props: ['visible', 'title', 'mode', 'orderId'],
  data() {
    return {
      // 产品清单表格数据
      productList: [],
      // 表单参数
      form: {
        taxNeed: false
      },
      // 客户信息
      clientInfo: {},
      // 开票信息
      taxInfo: {},
      // 产品查询参数
      productQueryParams: {
        productName:"",
        productAmount: null
      },
      // 列表加载动画
      loading: false
    }
  },
  methods: {
    async getOrderDetailInfo(id) {
      this.loading = true
      let response = await getOrder(id)
      this.loading = false
      this.clientInfo = response.data.clientInfo
      this.taxInfo = response.data.taxInfo
      this.productList = response.data.productList
      this.form.taxNeed = response.data.taxNeed == 1
      this.form.orderName = response.data.orderName
      this.form.handlerName = response.data.handlerName
      this.form.remark = response.data.remark
      this.form.actualPayment = parseFloat(response.data.actualPayment).toFixed(2)
    },
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
      this.clientInfo.clientNickname = item.value
      this.clientInfo.id = item.info.id
      this.clientInfo.clientPhone = item.info.clientPhone
      this.clientInfo.shippingAddress = item.info.shippingAddress
    },
    handleAdd() {
      let productAmount = this.productQueryParams.productAmount
      let info = Object.assign({}, this.productQueryParams.info) // 拷贝产品信息为独立实体
      this.productList.push(Object.assign(info, {
        productAmount: productAmount,
        productPrice: productAmount * info.productPrice
      }))
    },
    handleItemDeleteClick(e) {
      let index = this.productList.findIndex(item => Object.is(e, item))
      this.productList.splice(index, 1)
    },
    handleItemDownClick(e) {
      let index = this.productList.findIndex(item => Object.is(e, item))
      if (this.productList.length == 1 || index == this.productList.length -1) return
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
    },
    async submitForm() {
      this.loading = true
      this.mode = 1
      let response = await addOrder(Object.assign(this.form, {
        totalPrice: this.totalPrice,
        clientInfo: this.clientInfo,
        productList: this.productList,
        taxInfo: this.taxInfo,
        taxNeed: this.form.taxNeed ? 1 : 0
      }))
      this.restForm()
      this.mode = 0
      this.loading = false
      console.log(response)
    },
    restForm() {
      this.form = { taxNeed: false }
      this.clientInfo = {}
      this.taxInfo = {}
      this.productList = []
      this.productQueryParams = {
        productName:"",
        productAmount: null
      }
    }
  },
  computed: {
    totalPrice () {
      if(this.productList.length > 0) return this.productList.map(item => item.productPrice).reduce((prev, cur, index, arr) => prev + cur)
    },
    readOnly() {
      return this.mode == 1
    },
    edit() {
      return this.mode == 2
    },
    create() {
      return this.mode == 0
    }
  },
  watch: {
    visible(newVal, oldVal) {
      console.log(`newVal: ${newVal}, oldVal: ${oldVal}`)
      // 打开时
      if(newVal == true && oldVal == false) {
        if(this.mode == 1) this.getOrderDetailInfo(this.orderId)
      }
    }
  }
}
</script>

<style lang="scss">
  .el-dialog__close {
    padding: 5px;
    transition: background-color .2s;
    border-radius: 10%;
    &:hover {
      background: #E81123;
      &::before {
        color: #fff;
      }
    }
  }
  
</style>