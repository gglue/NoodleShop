import {Route, Routes} from "react-router-dom";
import Home from "./Home";
import Items from "./Items";


function App(){

    return (
        <div className ="App">
            <div className ="content">
                <Routes>
                    <Route exact path="/" element={<Home />}></Route>
                    <Route exact path="items" element={<Items />}></Route>
                </Routes>
            </div>
        </div>
    );
}
export default App;