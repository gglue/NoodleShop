import {Route, Routes} from "react-router-dom";
import Home from "./Home";
import Items from "./Items";
import NavigationBar from "./NavigationBar";
import {Container} from "@mui/material";


function App(){

    return (
        <div className ="App">
            <Container className ="content">
                <NavigationBar />
                <Routes>
                    <Route exact path="/" element={<Home />}></Route>
                    <Route exact path="items" element={<Items />}></Route>
                </Routes>
            </Container>
        </div>
    );
}
export default App;