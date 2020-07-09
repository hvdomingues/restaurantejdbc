import {http} from "./config"


export default {
    listAll:()=>{
        return http.get('menu')
    },
    createCategory:(categoryName)=>{
        return http.post('menu', "categoryName=" + categoryName)
    }

}