import React from 'react';
import Nav from '../components/ui/Nav';
import Landing from './Landing';
import {Element, scroller} from 'react-scroll';
import {Fade} from 'react-reveal';


const Home = () => {

    const scrollToLanding = elem => {
        scroller.scrollTo(elem, {
            duration: 800,
            delay: 100,
            smooth: true,            
        })
    }

    return (
        
        <div className="home">
            <Fade>
            <div className="home_header">
                <div className="wrapper">
                    <div className="logo"></div>
                    <Nav context="home"/>
                    <div className="home_caption" onClick={() => scrollToLanding('landing')}>EXPLORE BIOLIVE</div>
                    <div className="home_scroll-down"></div>
                </div>
            </div>
            </Fade>
            <Element name="landing">
            <Landing/>
            </Element>
        </div>
    );
};

export default Home;