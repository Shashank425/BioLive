import React from 'react';
import Socials from './ui/Socials';

const ContactUs = () => {
    return (
        <div className="product1">
        <div className="socials">
            <div className="product1_margin">
            <Socials context="contactus"/>
            </div>
        </div>
        <div className="product1_margin">
            <center>Select Your Prefernces Here.  Options are: 1. User Profile   2. Country select   3. </center>
        </div>   
        </div>
    );
};

export default ContactUs;