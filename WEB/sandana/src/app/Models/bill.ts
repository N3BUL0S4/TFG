export class Bill {
    billId: Number
    fech: Date
    hour: Number
    userId: String

    constructor(billId: Number, fech: Date, hour: Number, userId: String) {
        this.billId = billId,
        this.fech = fech,
        this.hour = hour,
        this.userId = userId
    }
}