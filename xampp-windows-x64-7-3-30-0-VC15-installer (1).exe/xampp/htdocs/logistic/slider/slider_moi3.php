<?php 
    class shop
    {
        
        function __construct($name,$meta_description,$image){
                $this->name=$name;
                $this->meta_description=$meta_description;
                $this->image=$image;
            }
        }
        $datashop = array(
            array('','','shoponline1.jpg'),
            array('','','shoponline2.jpg'),
            array('','','shoponline3.jpg'),
            array('','','shoponline4.jpg'),
            array('','','shoponline5.jpg'),
            array('','','shoponline6.jpg'),
            array('','','shoponline7.jpg'),
            array('','','shoponline8.jpg'),
        );
    
        
        $shop = array();
        foreach($datashop as $key => $value){
            array_push($shop,new shop($value[0],$value[1],$value[2]));
        }
?>
<style>
    .moi2 .owl-nav [class*=owl-]:hover {
        color: #b68944;
        background-color: unset;
    }
    .moi2>.owl-nav>.owl-next{
        top: 50%;
        position: absolute;
        left: -3vw;
    }
    .moi2>.owl-nav>.owl-prev{
        top: 50%;
        position: absolute;
        right: -3vw;
    }
    .card-text {
        min-height: 215px;
    }
    .card_img{
        height: 20vw;
    }
    @media (min-width: 768px){
        .card_img{
            height: 10vw;
        }
        .card-text {
            min-height: 150px;
        }
        .moi2>.owl-nav>.owl-next{
            top: 50%;
            position: absolute;
            left: -5vw;
        }
        .moi2>.owl-nav>.owl-prev{
            top: 50%;
            position: absolute;
            right: -5vw;
        }
    }
</style>




    <div class="px-0">
        <div class="moi2 owl-carousel owl-theme">
            
                <?php
                    foreach ($shop as $key => $value) {
                        # code...
                    
                ?>
                    <div class="card mx-4 h-100 border-0 shadow franchise-carousel-item">
                        <a href="https://www.wrapstyle.com" target="_blank" rel="noopener" tabindex="-1">
                            <img width="247" height="247" src="public/demo/<?php echo $value->image ?>" alt="WrapStyle Qatar" >
                        </a>
                    </div>
                <?php } ?>
            
        </div>   
    </div>




<script src="owlcarousel/owl.carousel.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){

        $('.moi2').owlCarousel({
            center: false,
            loop:true,
            margin:0,
            nav:true,
            dots:false,
            autoplay:true,
            responsive:{
                0:{
                    items:1
                },
                600:{
                    items:2
                },
                900:{
                    items:3
                }
            }
        });
        $( ".owl-next").html('<i class="bi bi-arrow-left-short fs-1"></i>');
         $( ".owl-prev").html('<i class="bi bi-arrow-right-short fs-1"></i>');


    });
</script>