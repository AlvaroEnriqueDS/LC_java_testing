(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
"use strict";

console.log("adasd");
var producto = {
  name: "Polo Keiko",
  imagenes: [{ ruta: '/assets/img/polo-1.jpg', select: true }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }],
  cantidad: 3,
  talla: "M",
  precio: 100,
  caja: "/assets/img/Caja.jpg",
  oferta: 0.25
},
    producto2 = {
  name: "Polo kenji",
  imagenes: [{ ruta: '/assets/img/polo-1.jpg', select: true }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }],
  cantidad: 5,
  talla: "M",
  precio: 200,
  caja: "/assets/img/Caja.jpg",
  oferta: 0.25
},
    producto3 = {
  name: "Polo Keiko",
  imagenes: [{ ruta: '/assets/img/polo-1.jpg', select: true }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }],
  cantidad: 3,
  talla: "M",
  precio: 100,
  caja: "/assets/img/Caja.jpg",
  oferta: 0.25
};
var vueCarrito = new Vue({
  el: "#carrito",
  data: {
    URLservetl: "/CarritoUsuario",
    productos: [producto, producto2, producto3]

  },
  computed: {
    precioFinal: function precioFinal(params) {
      var precioTotal = 0;
      this.productos.forEach(function (product) {
        precioTotal += product.precio * (1 - product.oferta) * product.cantidad;
      });
      return precioTotal.toFixed(2);
    }
  },
  created: function created() {
    if (localStorage.carrito === undefined) {
      this.loadCarrito();
    }
    localStorage.name = " jair";
  },
  mounted: function mounted() {
    try {
      if (localStorage.carrito !== undefined) {
        this.carrito = JSON.parse(localStorage.carrito);
      }
    } catch (error) {
      this.productosList = this.productosListRespaldo;
    }
  },

  methods: {
    eliminarProducto: function eliminarProducto(index) {
      this.productos.splice(index, 1);
      localStorage.removeItem(carrito);
      axios.post(this.URLservetl, { id: index }).then(function (response) {
        console.log(response);
      }).catch(function (error) {
        console.log(error);
      });
    },
    loadCarrito: function loadCarrito() {
      axios.get(this.URLservetl).then(function (response) {
        console.log(response.data);
        localStorage.carrito = JSON.stringify(response.data);
      }).catch(function (error) {
        console.log(error);
      });
    },
    comprar: function comprar() {
      if (this.productos.length === 0) {
        alert("Carro vacío");
      }
    }
  }

});

},{}]},{},[1]);

//# sourceMappingURL=carrito-min.js.map
