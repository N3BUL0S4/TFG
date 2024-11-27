export class Media{
    id: Number
    articleId:Number
    source:String

    constructor(id:Number, articleId:Number, source:String) {
        this.id = id
        this.articleId = articleId
        this.source = source
    }
}