(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
"use strict";

var product = new Vue({
  el: '#product',
  data: {
    cantidad: 1,
    tallas: [{ id: 0, name: "talla S", cod: "S", select: true }, { id: 1, name: "talla M", cod: "M", select: false }, { id: 2, name: "talla L", cod: "L", select: false }],
    tallasSeleccionada: { id: 0, name: "talla S", cod: "S", select: true },
    producto: {
      name: 'El polo Vue',
      disponibilidad: 43,
      descripcion: 'Lorem ipsum, dolor sit amet consectetur adipisicing elit. ',
      precio: 45,
      imagenes: [{ ruta: '/assets/img/polo-1.jpg', select: true }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }, { ruta: '/assets/img/polo-2.jpg', select: false }, { ruta: '/assets/img/polo-3.jpg', select: false }]
    },
    imagenProductoSeleccionado: {
      id: 0,
      ruta: ''
    },

    cajas: [{ id: 0, img: "/assets/img/Caja.jpg", select: true }, { id: 1, img: "/assets/img/Caja2.jpg", select: false }, { id: 2, img: "/assets/img/Caja.jpg", select: false }, { id: 3, img: "/assets/img/Caja2.jpg", select: false }],
    cajaSeleccionada: {
      id: 0,
      img: "/assets/img/Caja.jpg"
    }
  },
  computed: {
    precioTotal: function precioTotal(params) {
      return (this.cantidad * this.producto.precio).toFixed(2);
    }
  },
  mounted: function mounted() {
    this.imagenProductoSeleccionado.ruta = this.producto.imagenes[0].ruta;
  },

  methods: {
    selectCaja: function selectCaja(numeroDeLaCaja) {
      console.log(this.cajaSeleccionada + "asdsa");

      if (this.cajaSeleccionada.id != numeroDeLaCaja) {
        this.cajas[this.cajaSeleccionada.id].select = false;
        this.cajas[numeroDeLaCaja].select = true;
      }
      this.cajaSeleccionada.id = numeroDeLaCaja;
      this.cajaSeleccionada.img = this.cajas[numeroDeLaCaja].img;
    },

    selectImagen: function selectImagen(numeroDeLaImg) {

      if (!this.producto.imagenes[numeroDeLaImg].select) {
        this.producto.imagenes[this.imagenProductoSeleccionado.id].select = false;
        this.producto.imagenes[numeroDeLaImg].select = true;
      }
      this.imagenProductoSeleccionado.id = numeroDeLaImg;
      this.imagenProductoSeleccionado.ruta = this.producto.imagenes[numeroDeLaImg].ruta;
    },
    selectTalla: function selectTalla(params) {

      if (!this.tallas[params].select) {
        this.tallas[this.tallasSeleccionada.id].select = false;
        this.tallas[params].select = true;
      }
      this.tallasSeleccionada = this.tallas[params];
    }
  }

});

},{}]},{},[1]);

//# sourceMappingURL=product-min.js.map
