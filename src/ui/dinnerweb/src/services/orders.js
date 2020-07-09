import {http} from "./config"


export default {
    listByIndBillID:(indBillID)=>{
        return http.get('orders/' + indBillID)
    },
    createOrder:(indBillID)=>{
        return http.post('orders', "individualBillID=" + indBillID)
    }

}