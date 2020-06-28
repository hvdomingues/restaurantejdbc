<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="#">DinnerWeb</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarText"
        aria-controls="navbarText"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" v-on:click="mudarPagina(0)" href="#">
              Home
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" v-on:click="mudarPagina(1)" href="#">Bills</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" v-on:click="mudarPagina(2)" href="#">Relatórios</a>
          </li>
        </ul>
        <span class="navbar-text">
          <a href="https://github.com/hvdomingues/restaurantejdbc" target="_blank">
            <img src="../assets/github.png" width="20" height="20" />
          </a>
        </span>
      </div>
    </nav>
  </div>
</template>

<script>

export default {
  name: "NavBar",
  methods: {
    mudarPagina(numeroPagina) {
      this.$emit('mudarPagina',
          numeroPagina);
    }
  }
};
</script>