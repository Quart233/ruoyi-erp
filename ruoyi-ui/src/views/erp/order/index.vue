<template>
  <div class="app-container">
    <!-- <manager></manager> -->
    <bussiness></bussiness>
  </div>
</template>

<script>
import Manager from "./manager.vue"
import Bussiness from "./bussiness.vue"

export default {
  name: "Order",
  components: {
    Manager,
    Bussiness
  }
}
</script>

<style>

</style>