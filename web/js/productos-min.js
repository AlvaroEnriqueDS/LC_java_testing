(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
'use strict';

var productos = new Vue({
  el: '#productos',
  data: {
    URLservlet: '/productos',
    productosListRespaldo: [{ nomProdu: "EL Chapo", imagenes: [{ ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }], url: "/Producto", Precio: 125 }, { nomProdu: "EL Cuy", imagenes: { ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }, url: "/Producto", Precio: 1225 }, { nomProdu: "Batman", imagenes: { ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }, url: "/Producto", Precio: 1245 }, { nomProdu: "EL Keiko", imagenes: { ruta: "data:image/jpeg;base64,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" }, url: "/Producto", Precio: 1235 }, { nomProdu: "EL barnie", imagenes: { ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }, url: "/Producto", Precio: 1425 }, { nomProdu: "Manicero", imagenes: { ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }, url: "/Producto", Precio: 125 }, { nomProdu: "brocoli", imagenes: { ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }, url: "/Producto", Precio: 1215 }, { nomProdu: "Vegata", imagenes: { ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }, url: "/Producto", Precio: 1125 }, { nomProdu: "EL Chavarry", imagenes: { ruta: "data:image/jpeg;base64,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" }, url: "/Producto", Precio: 1625 }],
    productosList: [{ tallas: [], nomProdu: "EL Chapow", imagenes: [{ ruta: "https://cdn8.bigcommerce.com/s-ybxns/images/stencil/1024x1024/products/125/3519/g7s3k440_7_RegalBlue__06381.1525703565.png?c=2" }], url: "/Producto", Precio: 125 }],
    codigosDeEstado: {
      STATUS_OK: 200
    }

  },
  mounted: function mounted() {
    console.log(sessionStorage.productosList !== undefined);
    try {
      if (sessionStorage.productosList !== undefined) {
        this.productosList = JSON.parse(sessionStorage.productosList);
      }
    } catch (error) {
      this.productosList = this.productosListRespaldo;
    }
  },
  created: function created() {
    if (sessionStorage.productosList === undefined) {
      this.loadProductos();
    }
  },

  methods: {

    loadProductos: function loadProductos(params) {
      var _this = this;

      axios.get(this.URLservlet).then(function (response) {
        switch (response.status) {
          case _this.codigosDeEstado.STATUS_OK:
            console.log(response.data);
            _this.productosList = _this.ordenarProducto(response.data);
            console.log(_this.productosList);
            sessionStorage.productosList = JSON.stringify(_this.productosList);
            break;
          default:
            _this.productosList = _this.productosListRespaldo;
        }
      }).catch(function (error) {
        console.log(error);
        _this.productosList = _this.productosListRespaldo;
      });
    },
    ordenarProducto: function ordenarProducto(array) {
      var productosList = this.productosList;
      var CodId = 0,
          varDeEstado = "",
          tallaContador = "";
      array.forEach(function (producto) {

        if (producto.idProducto != CodId) {
          CodId = producto.idProducto;
          varDeEstado = producto.talla.talla;
          tallaContador = producto.talla.talla;

          var product = { imagenes: [],
            tallas: [] };

          product.nomProdu = producto.nomProdu;
          product.genero = producto.genero;
          product.idProducto = producto.idProducto;
          product.url = '/Producto?num=' + producto.idProducto;
          product.precio = 2000;

          var tallaStock = {};
          tallaStock.talla = producto.talla;
          tallaStock.stock = producto.stock;

          product.imagenes.push(producto.imagenes);
          product.tallas.push(tallaStock);
          productosList.push(product);
        } else {
          if (producto.talla.talla === tallaContador) {
            if (producto.talla.talla === varDeEstado) {
              productosList[producto.idProducto - 1].imagenes.push(producto.imagenes);
            } else {
              varDeEstado = "";
            }
          } else {
            tallaContador = producto.talla.talla;
            var _tallaStock = {};
            _tallaStock.talla = producto.talla;
            _tallaStock.stock = producto.stock;
            productosList[producto.idProducto - 1].tallas.push(_tallaStock);
          }
        }
      });
      return productosList;
    }
  }

});

},{}]},{},[1]);

//# sourceMappingURL=productos-min.js.map
