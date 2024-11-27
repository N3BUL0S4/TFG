export class LineCart {
    id: Number;
    articleId: Number;
    cantidad: number;
    cartId: Number;

    constructor(id: Number, articleId: Number, cantidad: number, cartId: Number) {
        this.id = id;
        this.articleId = articleId;
        this.cantidad = cantidad;
        this.cartId = cartId;
    }
}