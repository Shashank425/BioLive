import React from 'react';
import {Link, withRouter} from 'react-router-dom';

const Nav = props => {
    const {context, history} = props;
    const getClassName = pathname => (
        `main-nav__item ${history.location.pathname === pathname ? 'active' : ''}`
    )
    return (
        <div className={`main-nav main-nav--${context}`}>
            <Link className={getClassName('/products')} to="/products">Products</Link>
            <Link className={getClassName('/about')} to="/about">About Us</Link>
            <Link className={getClassName('/contact')} to="/contact">Contact Us</Link>
            <Link className={getClassName('/contact')} to="/contact">Preferences</Link>
            <Link className={getClassName('/feedback')} to="/feedback">Feedback</Link>
        </div>
    );
};

export default withRouter(Nav);