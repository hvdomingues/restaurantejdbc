<template>
  <div id="app" class="container text-center">
    <NavBar v-on:mudarPagina="mudarPagina" />
    <div id="div1">
      <img class="img-responsive" alt="Vue logo" src="./assets/restaurante.png" />
      <HelloWorld msg="Restaurante" />
    </div>
    <Bill v-if="pagina === 1" />
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import Bill from "./components/Bill.vue";
import NavBar from "./components/NavBar.vue";

export default {
  name: "App",
  components: {
    HelloWorld,
    Bill,
    NavBar
  },
  data: function() {
    return {
      pagina: 0
    };
  },
  methods:{
    mudarPagina(numeroPagina){
      this.pagina = numeroPagina;
    }
  }
};
</script>

<style>
</style>