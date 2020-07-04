import {http} from "./config"


export default {
    listByIndBillID:(indBillID)=>{
        return http.post('orders/' + indBillID)
    },
    createOrder:(indBillID)=>{
        return http.post('orders', "individualBillID=" + indBillID)
    }

}