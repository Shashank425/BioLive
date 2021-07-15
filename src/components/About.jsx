import React from 'react';
import Socials from './ui/Socials';

const About = () => {
    return (
        <div className="product1">
            <div className="socials">
                <div className="product1_margin">
                <Socials context="about"/>
                </div>
            </div>
            <div className="product1_margin"><center><p>
                This innovative product has been designed and developed by pop and son shop in 2019.  
                Due to Covid19 pandemic of 2020 it has taken the front seat in its implementation.
                This is a touch free on public BIOMETRIC device.  It uses built-in Fingerprint Scanner
                of the smartphone to register check-in and Check-out functions.
                </p>
                
                </center>
            </div>
        </div>
    );
};

export default About;