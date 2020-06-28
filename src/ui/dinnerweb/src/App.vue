<template>
  <div id="app">
    <div id="top">
      <NavBar v-on:mudarPagina="mudarPagina" />
    </div>
    <div id="conteudo" class="container text-center">
      <PaginaPrincipal v-if="pagina === 0" />
      <Bill v-if="pagina === 1" />
      <Relatorios v-if="pagina === 2" />
    </div>
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
import PaginaPrincipal from "./components/PaginaPrincipal.vue";
import Bill from "./components/Bill.vue";
import Relatorios from "./components/Relatorios.vue";

export default {
  name: "App",
  components: {
    Bill,
    NavBar,
    PaginaPrincipal,
    Relatorios
  },
  data: function() {
    return {
      pagina: 0
    };
  },
  methods: {
    mudarPagina(numeroPagina) {
      this.pagina = numeroPagina;
    }
  }
};
</script>
  

<style>
body,
html {
  height: 100%;
}

div#app {
  height: 100%;
}

div#conteudo {
  height: 100%;
  align-items: center;
display: flex;
flex-direction: row;
flex-wrap: wrap;
justify-content: center;
}


</style>