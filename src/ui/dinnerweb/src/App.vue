<template>
  <div id="app" class="container text-center">
    <div id="div1">
      <img class="img-responsive" alt="Vue logo" src="./assets/restaurante.png" >
      <HelloWorld msg="Restaurante"/>
    </div>
    <Bill/>
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