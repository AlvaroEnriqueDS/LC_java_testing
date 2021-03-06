(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
'use strict';

var _example = require('./modules/example');

var _activeMenu = require('./modules/active-menu');

// saludo()
// despedida()
(0, _activeMenu.activeMenu)();
new Vue({
  el: '#vuemenu',
  data: {
    menu: "hola gente",
    estadoSesion: 'off'

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

    if (localStorage.estadoSesion === 'on') {
      this.estadoSesion = localStorage.estadoSesion;
    } else {
      this.estadoSesion = localStorage.estadoSesion;
    }
  },

  methods: {
    desloguearse: function desloguearse() {
      this.estadoSesion = 'off';
      localStorage.clear();
      alert("Cerró sesión");
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
    }
  }

});

},{"./modules/active-menu":2,"./modules/example":3}],2:[function(require,module,exports){
'use strict';

Object.defineProperty(exports, "__esModule", {
    value: true
});
var activeMenu = exports.activeMenu = function activeMenu() {
    var menu = document.getElementById('main-menu');
    if (menu) {
        var links = Array.from(menu.querySelectorAll('a'));
        links.map(function (link) {
            if (link.href === location.href || link.href === location.href.slice(0, -1)) link.classList.add('active');
        });
    }
};

},{}],3:[function(require,module,exports){
'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

// Este es un ejemplo de como exportar funciones desde un archivo
// En index.js se importan estas funciones

var saludo = exports.saludo = function saludo() {
  console.log('Hola mundo');
};

var despedida = exports.despedida = function despedida() {
  console.log('Adiós mundo');
};

var Producto = exports.Producto = function Producto(name, descripcion, precio) {
  _classCallCheck(this, Producto);

  this.name = name;
  this.descripcion = descripcion;
  this.precio = precio;
};

var producto = new Producto("perro", "asdadasd", 333);
var producto2 = new Producto();

},{}]},{},[1]);

//# sourceMappingURL=scripts-min.js.map
