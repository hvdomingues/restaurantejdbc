template>
    
</template>

<script>
import $ from 'jquery';
var dataURL = 'http://localhost:8080/bills';

export default {
    name: 'Bills',
    data() {
        return{
            bills: []
        } 
    },
    methods: {
        setBills(){
            var self = this; // create a closure to access component in the callback below
            self.bills = $.getJSON(dataURL);
            return self.bills;
        }
    }
        
}
</script>





