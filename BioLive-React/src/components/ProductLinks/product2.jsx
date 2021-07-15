import React from 'react';
import {Fade} from 'react-reveal';

const product2 = () => {
    return (
        <div className="product2">
            <Fade>
            <div className="product2_margin">
                <h3>Provide product registration details below:(10 day 10 member Free Eval)</h3>
            </div>
            <div className="product2_margin">
                Admin user will receive login cridentials on the email address provided below.
                Use this cridential to login to BioLive on your Smartphone.  
                Additional user details can be uploaded on admin Mobile Phone OR you could ask them to click 'New User'.
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="Company Name"/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="First Name"/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="Last Name"/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="Address"/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="City"/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="State/Country "/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="Phone Number"/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="Designation"/>
            </div>
            <div className="product2_margin">
            <input type="text" placeholder="Email"/>
            </div>
            <div className="product2_margin">
            <button type="button"><span>Submit</span></button> <button type="button"><span>Cancel</span></button>
            </div>
            </Fade>
        </div>
    );
};

export default product2;