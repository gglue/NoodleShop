import axios from "axios";
import {useEffect, useState} from "react";
import {Button, Card} from "@mui/material";

function Items(){
    const [items, setItems] = useState(null);
    const [extras, setExtras] = useState(null);
    const [loading, setLoading] = useState(true);
    const [itemInfo, setItemInfo] = useState(null);

    const formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'CAD',
    });
    useEffect(() => {
       axios.get("http://10.0.0.109:8080/data-api/items", {
           headers: {
               'Content-Type': 'application/json',
               Authorization: 'Bearer ' + localStorage.getItem('token')
           },
       })
           .then(res => {
               setItems(res.data._embedded.items);
               setLoading(false);
           })

        axios.get("http://10.0.0.109:8080/data-api/extras", {
            headers: {
                'Content-Type': 'application/json',
                Authorization: 'Bearer ' + localStorage.getItem('token')
            },
        })
            .then(res => {
                setExtras(res.data._embedded.extras);
            })
    }, []);

    function printItems(){
        let counter = 0;
        console.log(items);
        return(
            items.map(item => (
                <Card key={counter++} sx={{marginBottom: 5, marginTop : 0}} onClick={() => {console.log(extras)}}>
                    <h1>{item.name}</h1>
                    <img src="https://www.kitchenskip.com/wp-content/uploads/2021/04/how-to-cook-rice-noodles-f_.jpg"
                    style ={{height: 100, width: 100}}/>
                    <h1>{formatter.format(item.price/100)}</h1>
                </Card>
            ))
        )
    }
    return (
        <nav className = "items" >
            <div style={{columns: 3}}>
               {loading ? <div>Loading :)</div> : printItems()}
            </div>
            <Button>Continue to Checkout</Button>
        </nav>
    );
}

export default Items;