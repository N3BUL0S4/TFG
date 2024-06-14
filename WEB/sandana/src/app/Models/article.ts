export class article{
    
    id:Number
    description:String
    model:String
    size:String
    color:String
    stok:String

    constructor(id:number, description:String, model:String, size:String, color:String, stok:String) {
        this.id = id
        this.description = description
        this.model = model
        this.size = size
        this.color = color
        this.stok = stok
    }
}