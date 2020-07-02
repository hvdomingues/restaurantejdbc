import {http} from "./config"


export default {

    listByBillID:(billid)=>{
        return http.get('individualbills/' + billid)
    },
    createIndBill:(observation,tabPosition,billID)=>{
        
        return http.post('individualbills', "billID=" + billID + "&observation=" + observation +  "&tabPosition=" + tabPosition)
    }

}