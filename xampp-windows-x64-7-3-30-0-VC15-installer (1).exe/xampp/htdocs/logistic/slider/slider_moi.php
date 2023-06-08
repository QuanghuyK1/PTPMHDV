<style>

    .moi>.owl-nav>.owl-next{
        top: 26%;
        position: absolute;
        left: 0vw;
    }
    .moi>.owl-nav>.owl-prev{
        top: 26%;
        position: absolute;
        right: 0vw;
    }
    .card_img{
        height: 20vw;
    }
    @media (min-width: 768px){
    .card_img{
        height: 10vw;
    }
}
</style>
<div class="row">
    <div class="">
        <div class="moi owl-carousel owl-theme">
            <div class="bg card_img laydata2" style="background-image:url(img/gallery_detail_2.jpeg)" data-hinh2="url(img/gallery_detail_2.jpeg)">
                
            </div>
            <div class="bg card_img laydata3" style="background-image:url(img/gallery_detail_3.jpeg)" data-hinh3="url(img/gallery_detail_3.jpeg);">
                
            </div>
            <div class="bg card_img laydata4" style="background-image:url(img/gallery_detail_4.jpeg)" data-hinh4="url(img/gallery_detail_4.jpeg);">
                
            </div>
        </div>   
    </div>

</div>


<script src="owlcarousel/owl.carousel.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){

        $('.moi').owlCarousel({
            center: false,
            loop:true,
            margin:0,
            nav:false,
            dots:false,
            autoplay:true,
            responsive:{
                0:{
                    items:3
                },
                600:{
                    items:3
                }
            }
        });
        $( ".owl-next").html('<i class="bi bi-arrow-left-short fs-1"></i>');
         $( ".owl-prev").html('<i class="bi bi-arrow-right-short fs-1"></i>');


    });
</script>