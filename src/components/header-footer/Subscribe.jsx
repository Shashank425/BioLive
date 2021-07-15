import React from 'react';
import Button from '../ui/Button';

const Subscribe = () => {
    return (
        <div className="subscribe">
            <input type="text" placeholder="Your Email"/>
            <select>
                <option value="">Select Your Country</option>
            </select>
            <div className="subscribe__agreement">
                <input type="checkbox" id="agreement"/>
                <label htmlFor="agreement">By submitting the above information,
                 I acknowledge that I have reviewed and hereby agree to the Privacy Policy
                 and terms of use.</label>
            </div>
            <Button type="submit" text="Join" context="footer"/>
        </div>
    );
};

export default Subscribe;