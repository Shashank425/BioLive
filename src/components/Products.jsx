import React from 'react';

import {Link} from 'react-router-dom';
import {Fade} from 'react-reveal';

const Products = () => {
    return(
        <div className="product">
                <Fade>
                    <div className="product_row">
                        <div className="product_column">
                            <div className="product_centerBlock">
                            <div className="product_caption"><b><div className="text_freecolor"> FREE Evaluation</div></b></div>
                            </div>
                            <div className="product_centerBlock">
                            <div className="text"> 
                            <center>
                            Multiple users can experience real-life 'BioMetric' under this trial version using their Smartphones. 
                            <p>
                            The first user will have the admin privileges and configure additional users of the enterprise or could 
                            ask individual setup besides generating crystal reports.
                            </p></center> 
                            </div>
                            </div>

                            <div className="prod-button_margin">
                            <div className="product_centerBlock">
                            <Link to="/productlinks/product1">
                                <button className="prod-button"><span>5 day, 5 member FREE evaluation</span></button>
                                </Link>
                            </div>
                            </div>                     
                            <div className="prod-button_margin">
                            <div className="product_centerBlock">   
                            <Link to="/productlinks/product2">
                            <button className="prod-button"><span>10 day, 10 member FREE evaluation</span></button>
                            </Link>
                                </div>
                            </div>
                        </div> 
                                           
                        <div className="product_column">
                        <div className="product_centerBlock">
                            <div className="product_caption"><b><div className="text_buycolor">Buy Complete Product</div></b></div>
                            </div>
                            <div className="product_centerBlock">
                            <div className="text"><center>
                            Purchasing this product will give your enterprise multiple user accounts.
                            Your enterprise database can be used for backend data interactions if Biometric system already exist.
                            <p>For new Biometric users a database will be installed on your back end server for finger print and other 
                            data storge and retrieveal.
                            </p>
                                </center></div>
                            </div>
                            <div className="prod-button_margin">
                            <div className="product_centerBlock">
                            <Link to="/productlinks/product3">
                            <button className="prod-button"><span>Buy BioLive upto 500 users: INR. X </span></button>
                            </Link>
                                </div>
                            </div>
                            <div className="prod-button_margin">
                            <div className="product_centerBlock">
                                <Link to="/productlinks/product4">
                                <button className="prod-button"><span>Buy BioLive upto 5000 users: INR. Y  </span></button>
                                </Link>
                                </div>
                            </div>
                            <div className="prod-button_margin">
                            <div className="product_centerBlock">
                                <Link to="/productlinks/product5">
                                <button className="prod-button"><span>Buy BioLive Unlimited Users: INR. Z </span></button>
                                </Link>
                                </div>
                            </div>
                        </div>
                    </div>
                    </Fade>
                   
        </div>
    );
};
export default Products;