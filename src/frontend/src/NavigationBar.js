import {AppBar, Button, Toolbar, Typography} from "@mui/material";

function NavigationBar(){
    return (
        <AppBar position="static" sx={{bgcolor : "green", marginBottom: 3}}>
            <Toolbar>
                <Typography variant="h6">Java Noodles</Typography>
                <Button color="inherit">Menu</Button>
                <Button color="inherit">Your Orders</Button>
                <Button color="inherit">Login</Button>
            </Toolbar>
        </AppBar>
    );
}

export default NavigationBar;