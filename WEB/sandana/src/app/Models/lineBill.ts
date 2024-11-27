export class LineBill {
    id:Number
    amount:Number
    articleId:Number
    billId:Number
    pvp:Number

    constructor(id:Number, amount:Number, articleId:Number, billId:Number, pvp:Number) {
        this.id = id
        this.amount = amount
        this.articleId = articleId
        this.billId = billId
        this.pvp = pvp
    }
}