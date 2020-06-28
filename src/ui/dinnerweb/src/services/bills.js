import {http} from "../services/config"


export default {

    listActive:() => {
        return http.get('bills' + '/active')
    },

    listInactive:() => {
        return http.get('bills' + '/inactive')
    },

    listAll:() => {
        return http.get('bills')
    },

    create:(numeroMesa) => {
        return http.post('bills', numeroMesa)
    }

}