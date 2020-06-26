<template>
  <div id="app" class="container text-center">
    <div id="div1">
      <img class="img-responsive" alt="Vue logo" src="./assets/restaurante.png" >
      <HelloWorld msg="Restaurante"/>
    </div>
    <div id="div2">
      <HelloWorld msg="Sua mãe"/>
      <Bill/>
    </div>
    <div class="row mx-md-n5">
      <div class="col py-3 px-md-5 border bg-light">Custom column padding</div>
      <div class="col py-3 px-md-5 border bg-light">Custom column padding</div>
    </div>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Bill from './components/Bill.vue'


export default {
  name: 'App',
  components: {
    HelloWorld,
    Bill
  }
}



</script>

<style>
  
</style>