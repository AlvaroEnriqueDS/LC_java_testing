(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
'use strict';

new Vue({
  el: '#vuemenu',
  data: {
    menu: "hola gente",
    estadoSesion: 'off',
    nombre: 's',
    apellido: '',
    correo: "",
    contraseña: '',
    MensajeRegistro: '',
    MensajeIngreso: '',
    MensajeLoading1: '',
    MensajeLoading2: '',
    UsuarioIngreso: {
      correo: '',
      contrasena: '' },
    UsuarioRegistro: {
      nombres: '',
      apellidos: '',
      correo: '',
      contrasena: '',
      repetirContrasena: '' }
  },
  computed: {
    isActive: function isActive() {
      if (this.estadoSesion === 'on') {
        return true;
      } else {
        return false;
      }
    }
  },
  mounted: function mounted() {
    this.nombre = localStorage.nombre;
    this.correo = localStorage.correo;
    this.estadoSesion = localStorage.estadoSesion;
  },

  methods: {
    desloguearse: function desloguearse() {
      this.estadoSesion = 'off';
      localStorage.clear();
      alert("Cerró sesión");
      this.correo = '';
      this.contraseña = '';
    },
    loguearse: function loguearse() {
      this.estadoSesion = 'on';
      localStorage.estadoSesion = 'on';
    },
    showMenu: function showMenu(toggleId, id1, id2, id3, id35, id4, navId) {

      var toggle = document.getElementById(toggleId),
          nav = document.getElementById(navId),
          headerItems = document.getElementById(id1),
          headerItem1 = document.getElementById(id2),
          headerItem2 = document.getElementById(id3),
          headerItem3 = document.getElementById(id35),
          mainList = document.getElementById(id4);
      if (toggle && nav && headerItems) {

        nav.classList.toggle('main-header__item2__active');
        nav.classList.toggle('main-header__item2');
        headerItems.classList.toggle('main-header__item3__active');
        headerItems.classList.toggle('main-header__item3');
        headerItem1.classList.toggle('main-header__item3__active__first');
        headerItem2.classList.toggle('main-header__item3__active__second');
        if (headerItem3) {
          headerItem3.classList.toggle('main-header__item3__active__third');
        }

        mainList.classList.toggle('main-menu-list__active');
      }
      console.log('hi');
    },
    activarShowMenu: function activarShowMenu() {
      this.showMenu('boton-main', 'header-items', 'header-items-1', 'header-items-2', "header-items-3", 'main-list', 'nav-main');
    },
    sendFormIngreso: function sendFormIngreso(e) {
      var _this = this;

      this.MensajeIngreso1 = '';
      this.MensajeLoading = 'Cargando ...';
      axios.post('/Perfil/login', {
        correo: this.UsuarioIngreso.correo,
        contrasena: this.UsuarioIngreso.contrasena
      }).then(function (response) {
        console.log(response);
        console.log(response.data.nombre);

        console.log(_this.nombre);
        //CODIGO SI EL INGRESO ES CORRECTO
        if (response.data.correo === _this.correo) {
          _this.nombre = response.data.nombre;
          _this.correo = response.data.correo;
          localStorage.nombre = response.data.nombre;
          localStorage.correo = response.data.correo;

          localStorage.estadoSesion = "on";
          _this.estadoSesion = "on";
          alert("Ingresó correctamente");
          _this.MensajeIngreso = '';
          _this.MensajeLoading1 = '';
        } else {
          _this.contraseña = '';
          _this.MensajeLoading1 = '';
          _this.MensajeIngreso = "Datos Incorrectos";
        }
      }).catch(function (error) {
        _this.MensajeLoading1 = '';
        _this.MensajeIngreso = "Sucedio error en el servidor";
        console.log(error);
      });
    },
    sendFormRegistro: function sendFormRegistro(e) {
      var _this2 = this;

      this.MensajeRegistro = '';
      this.MensajeLoading = 'Cargando ...';
      axios.post('/Perfil/register', {
        nombres: this.UsuarioRegistro.nombres,
        apellidos: this.UsuarioRegistro.apellidos,
        correo: this.UsuarioRegistro.correo,
        contrasena: this.UsuarioRegistro.contrasena,
        repetirContrasena: this.UsuarioRegistro.repetirContrasena
      }).then(function (response) {
        console.log(response);

        //CODIGO SI EL REGISTRO ES CORRECTO
        if (response.data.correo === _this2.correo) {
          _this2.nombre = response.data.nombre;
          _this2.correo = response.data.correo;
          localStorage.nombre = response.data.nombre;
          localStorage.correo = response.data.correo;
          localStorage.apellido = response.data.apellido;
          localStorage.estadoSesion = "on";
          _this2.estadoSesion = "on";
          alert("Ingresó incorrectamente");
          _this2.MensajeRegistro = '';
          _this2.MensajeLoading2 = '';
        } else {
          _this2.contraseña = '';
          _this2.MensajeLoading2 = '';
          _this2.MensajeRegistro = "No se pudo registrar";
        }
      }).catch(function (error) {
        _this2.MensajeLoading2 = '';
        _this2.MensajeRegistro = "Sucedio error en el servidor";
        console.log(error);
      });
    },
    validacion: function validacion(pass, repass) {
      if (pass === repass && pass !== "") {
        this.sendFormRegistro();
      } else {
        this.MensajeRegistro = "Contraseñas Desiguales";
      }
    },
    validateData: function validateData(e) {
      var input = e.target,
          expression = void 0;

      if (input.pattern) {
        var regex = new RegExp(input.pattern);
        expression = !regex.exec(input.value);
      } else {
        expression = !input.value;
      }

      if (expression) {
        input.className += " borderRojo";
        console.log("incorrecto");
      } else {
        console.log("correcto");
      }
    }
  }

});

},{}]},{},[1]);

//# sourceMappingURL=logueo-min.js.map
