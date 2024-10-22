export class lineCart {
    id: Number;
    articleId: Number;
    amount: Number;
    cartId: Number;

    constructor(id: Number, articleId: Number, amount: Number, cartId: Number) {
        this.id = id;
        this.articleId = articleId;
        this.amount = amount;
        this.cartId = cartId;
    }
}