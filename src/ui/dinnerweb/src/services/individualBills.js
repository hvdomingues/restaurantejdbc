import {http} from "./config"


export default {

    listByBillID:(billid)=>{
        return http.get('individualbills/' + billid)
    } 

}