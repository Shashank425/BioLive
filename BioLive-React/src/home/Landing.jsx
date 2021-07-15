import React from 'react';
import {Fade} from 'react-reveal';

const Landing = () => {
    return (
        <div className="landing"> 
        <Fade>
            <div className="landing_column">
                <img src="/img/biol.png" alt="Logo"/>
            </div>
            <div className="landing_column_text">
                <h2><b><center>About BioLive:</center></b></h2>
                <p><b><center>
                Biolive; a biometric Android App on your Smartphone enable users to log in their 
                daily Biometrics using Fingerprint Scanner on their mobile phones. 
                Check-in and Check-Out date&timestamps are stored on the enterprise backend server 
                after initial validation. Historical data can be retireved on daily/weekly/monthly 
                crystal reports.
                </center></b></p>
            </div>
            </Fade>
        </div>
    );
};

export default Landing;