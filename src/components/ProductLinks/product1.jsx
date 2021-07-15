import React from 'react';
import {Fade} from 'react-reveal';
import { Link } from 'react-router-dom';

const product1 = () => {

    
    return (
        <div className="product1">
            <Fade>
            <div className="product1_margin">
                <h3>Provide product registration details below: (5 day 5 member Free Eval)</h3>
            </div>
            <div className="product1_margin">
                Admin user will receive login cridentials on the email address provided below.
                Use this cridential to login to BioLive on your Smartphone.  
                Additional user details can be uploaded on admin Mobile Phone OR you could ask them to click 'New User'.
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="Company Name"/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="First Name"/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="Last Name"/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="Address"/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="City" required/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="State/Country "/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="Phone Number"/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="Designation"/>
            </div>
            <div className="product1_margin">
            <input type="text" placeholder="Email" required/>
            </div>
            <div className="product1_margin">
            <Link to="productlinks/success">
            <button type="productlinks/submit"><span>Submit</span></button></Link> 
            <button type="button"><span>Cancel</span></button>
            </div>
            </Fade>
        </div>
    );
};

export default product1;