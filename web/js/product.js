!function e(a,t,i){function s(o,l){if(!t[o]){if(!a[o]){var n="function"==typeof require&&require;if(!l&&n)return n(o,!0);if(c)return c(o,!0);var d=new Error("Cannot find module '"+o+"'");throw d.code="MODULE_NOT_FOUND",d}var r=t[o]={exports:{}};a[o][0].call(r.exports,function(e){var t=a[o][1][e];return s(t||e)},r,r.exports,e,a,t,i)}return t[o].exports}for(var c="function"==typeof require&&require,o=0;o<i.length;o++)s(i[o]);return s}({1:[function(e,a,t){"use strict";new Vue({el:"#product",data:{cantidad:1,tallas:[{id:0,name:"talla S",cod:"S",select:!0},{id:1,name:"talla M",cod:"M",select:!1},{id:2,name:"talla L",cod:"L",select:!1}],tallasSeleccionada:{id:0,name:"talla S",cod:"S",select:!0},producto:{name:"El polo Vue",disponibilidad:43,descripcion:"Lorem ipsum, dolor sit amet consectetur adipisicing elit. ",precio:45,imagenes:[{ruta:"/assets/img/polo-1.jpg",select:!0},{ruta:"/assets/img/polo-2.jpg",select:!1},{ruta:"/assets/img/polo-3.jpg",select:!1},{ruta:"/assets/img/polo-2.jpg",select:!1},{ruta:"/assets/img/polo-3.jpg",select:!1}]},imagenProductoSeleccionado:{id:0,ruta:""},cajas:[{id:0,img:"/assets/img/Caja.jpg",select:!0},{id:1,img:"/assets/img/Caja2.jpg",select:!1},{id:2,img:"/assets/img/Caja.jpg",select:!1},{id:3,img:"/assets/img/Caja2.jpg",select:!1}],cajaSeleccionada:{id:0,img:"/assets/img/Caja.jpg"}},computed:{precioTotal:function(e){return(this.cantidad*this.producto.precio).toFixed(2)}},mounted:function(){this.imagenProductoSeleccionado.ruta=this.producto.imagenes[0].ruta},methods:{selectCaja:function(e){console.log(this.cajaSeleccionada+"asdsa"),this.cajaSeleccionada.id!=e&&(this.cajas[this.cajaSeleccionada.id].select=!1,this.cajas[e].select=!0),this.cajaSeleccionada.id=e,this.cajaSeleccionada.img=this.cajas[e].img},selectImagen:function(e){this.producto.imagenes[e].select||(this.producto.imagenes[this.imagenProductoSeleccionado.id].select=!1,this.producto.imagenes[e].select=!0),this.imagenProductoSeleccionado.id=e,this.imagenProductoSeleccionado.ruta=this.producto.imagenes[e].ruta},selectTalla:function(e){this.tallas[e].select||(this.tallas[this.tallasSeleccionada.id].select=!1,this.tallas[e].select=!0),this.tallasSeleccionada=this.tallas[e]}}})},{}]},{},[1]);
//# sourceMappingURL=product.js.map
