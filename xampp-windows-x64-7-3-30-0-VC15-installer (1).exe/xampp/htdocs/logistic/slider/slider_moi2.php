<?php 
    class homeslider
    {
        
        function __construct($name,$meta_description,$image){
                $this->name=$name;
                $this->meta_description=$meta_description;
                $this->image=$image;
            }
        }
        $datahomeslider = array(
            array('WrapStyle','WrapStyle is expanding to Slovakia!Finally, we can inform you that a few days ago we opened a new and at the same time the very first branch in Slovakia, specifically in Bratislava.One year passed from the first idea to the…','OpticShield-NANO-1200-675-News-FINAL.jpeg'),
            array('WrapStyle','WrapStyle is expanding to Slovakia!Finally, we can inform you that a few days ago we opened a new and at the same time the very first branch in Slovakia, specifically in Bratislava.One year passed from the first idea to the…','news_img_4.jpeg'),
            array('WrapStyle','WrapStyle is expanding to Slovakia!Finally, we can inform you that a few days ago we opened a new and at the same time the very first branch in Slovakia, specifically in Bratislava.One year passed from the first idea to the…','Open-WS-Slovakia.jpeg'),
            array('WrapStyle','WrapStyle is expanding to Slovakia!Finally, we can inform you that a few days ago we opened a new and at the same time the very first branch in Slovakia, specifically in Bratislava.One year passed from the first idea to the…','Back-in-KOTVA-NEWS.jpeg'),
            array('WrapStyle','WrapStyle is expanding to Slovakia!Finally, we can inform you that a few days ago we opened a new and at the same time the very first branch in Slovakia, specifically in Bratislava.One year passed from the first idea to the…','WhatsApp-Image.jpeg'),
        );
    
        
        $homeslider = array();
        foreach($datahomeslider as $key => $value){
            array_push($homeslider,new homeslider($value[0],$value[1],$value[2]));
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
                    foreach ($homeslider as $key => $value) {
                        # code...
                    
                ?>
                    <div class="card mx-4 h-100 border-0 shadow franchise-carousel-item">
                        <a href="https://www.wrapstyle.com" target="_blank" rel="noopener" tabindex="-1">
                            <img class="img-fluid" src="img/<?php echo $value->image ?>" alt="WrapStyle Qatar" >
                        </a>
                        <div class="card-body ">
                            <h4 class="card-title mb-3 text-center "><a class="link-service text-decoration-none text-dark" href="https://www.wrapstyle.com" target="_blank" rel="noopener" tabindex="-1"> <?php echo $value->name ?> </a></h4>
                            <div class="card-text text-grey">
                               <?php echo $value->meta_description ?>
                            </div>
                        </div>
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