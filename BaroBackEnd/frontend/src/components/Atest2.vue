<template>
  <div>
    <br><br><br><br><br>

    {{$store.state.test}}
    <button @click="tM()">뭐</button>
    <hr>
  </div>
</template>

<script>
export default {
  name: 'App',
  props: ['num'],
  component: {
  },
  methods: {
    tM () {
      this.$store.state.test = 'Y'
    }
  }
}
</script>

<style>

</style>
