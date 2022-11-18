import axios from "axios";
import {useEffect} from "react";

function Items(){

    useEffect(() => {
       axios.get("http://10.0.0.110:8080/data-api/items", {
           headers: {
               'Content-Type': 'application/json',
               Authorization: 'Bearer ' + localStorage.getItem('token')
           },
       })
           .then(res => {
               console.log(res.data._embedded.items);
           })

        axios.get("http://10.0.0.110:8080/data-api/extras", {
            headers: {
                'Content-Type': 'application/json',
                Authorization: 'Bearer ' + localStorage.getItem('token')
            },
        })
            .then(res => {
                console.log(res.data._embedded.extras);
            })
    });

    return (
        <nav className = "items">
            hello :)
        </nav>
    );
}

export default Items;