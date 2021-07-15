import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route} from 'react-router-dom';
import './main.scss';
import Header from './components/header-footer/Header';
import Home from './home/Home';
import Footer from './components/header-footer/Footer';
import Products from './components/Products';
import product1 from "./components/ProductLinks/product1";
import product2 from "./components/ProductLinks/product2";
import product3 from "./components/ProductLinks/product3";
import product4 from "./components/ProductLinks/product4";
import product5 from "./components/ProductLinks/product5";
import About from './components/About';
import ContactUs from './components/ContactUs';
import Feedback from './components/Feedback';
import Success from './components/ProductLinks/Success'

const Routes = () => (
    <BrowserRouter>
        <div>
            <Route path="/" render={ props => (props.location.pathname !== '/') && <Header/> }/>
            <Route exact path="/" component={Home}/>
            <Route exact path="/products" component={Products}/>
            <Route exact path='/productlinks/product1' component={product1}/>
            <Route exact path='/productlinks/product2' component={product2}/>
            <Route exact path='/productlinks/product3' component={product3}/>
            <Route exact path='/productlinks/product4' component={product4}/>
            <Route exact path='/productlinks/product5' component={product5}/>
            <Route exact path='/productlinks/success' component={Success}/>
            <Route exact path='/about' component={About}/>
            <Route exact path='/contact' component={ContactUs}/>
            <Route exact path='/feedback' component={Feedback}/>
            <Footer/>
        </div>
    </BrowserRouter>
)

ReactDOM.render(<Routes/>, document.getElementById('root'));