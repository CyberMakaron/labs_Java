<template>
  <div id="app" class="wrapper bg_gray">
    <header>
      <nav class="navbar navbar-expand navbar-dark bg-dark mb-4">
<!--        <div class="container">-->
          <router-link class="navbar-brand mx-5" v-bind:to="{name: 'Home'}">ЖД Билеты</router-link>
            <ul class="navbar-nav ml-auto mr-5">
              <li class="nav-item" v-if="user.isAuth()">
                <router-link class="nav-link" v-bind:to="{name: 'MyTickets'}">Мои билеты</router-link>
              <li class="nav-item" v-if="user.isAuth()">
                <router-link class="nav-link" v-bind:to="{name: 'Profile'}">{{ user.name }}</router-link>
              <li class="nav-item" v-else>
                <router-link class="nav-link" v-bind:to="{name: 'SingIn'}">Войти</router-link>
              </li>
            </ul>
      </nav>
    </header>

    <main class="content">
      <router-view/>
    </main>

    <footer class="container footer mt-5">
      <hr class="featurette-divider">
      <p class="float-right"><a href="#top">Back to top</a></p>
      <p>&copy; 2020 БГТУ Клесов ВТ-41</p>
<!--      <p>&copy; 2020 БГТУ Клесов ВТ-41 &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>-->
    </footer>
  </div>
</template>

<script>
import User from '@/components/User'
export default {
  data() {
    return {
      user: User
    }
  }
}
</script>