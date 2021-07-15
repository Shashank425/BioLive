import React from 'react';
import Socials from './ui/Socials';

const Feedback = () => {
    return (
        <div className="product1">
            <div className="socials">
                 <div className="product1_margin">
                      <Socials context="feedback"/>
                 </div>
             </div>
        <div className="product1_margin">
            <center>Please Provide your feedback in the box below.  
                    The feedback data will be kept confidential and used for our internal development/improvement only.</center>
        </div> 
        </div>           
    );
};

export default Feedback;