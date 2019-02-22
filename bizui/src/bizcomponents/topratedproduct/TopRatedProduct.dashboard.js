

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './TopRatedProduct.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(topRatedProduct)=>{return [
	   {"title":'Product Cover Image',"imageLocation":topRatedProduct.productCoverImage},
]}

const internalImageListOf = (topRatedProduct) =>defaultImageListOf(topRatedProduct,imageList)

const optionList =(topRatedProduct)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (topRatedProduct) =>defaultSettingListOf(topRatedProduct, optionList)
const internalLargeTextOf = (topRatedProduct) =>{

	return(<div> 
   <Card title={`Remark`} ><pre>{topRatedProduct.remark}</pre></Card>
</div>)

	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (topRatedProduct,targetComponent) =>{
	
	
	const {TopRatedProductService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{topRatedProduct.id}</Description> 
<Description term="Name">{topRatedProduct.name}</Description> 
<Description term="Parent Category">{topRatedProduct.parentCategory==null?appLocaleName(userContext,"NotAssigned"):topRatedProduct.parentCategory.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Parent Category","levelNCategory",TopRatedProductService.requestCandidateParentCategory,
	      TopRatedProductService.transferToAnotherParentCategory,"anotherParentCategoryId",topRatedProduct.parentCategory?topRatedProduct.parentCategory.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Brand">{topRatedProduct.brand==null?appLocaleName(userContext,"NotAssigned"):topRatedProduct.brand.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Brand","brand",TopRatedProductService.requestCandidateBrand,
	      TopRatedProductService.transferToAnotherBrand,"anotherBrandId",topRatedProduct.brand?topRatedProduct.brand.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Origin">{topRatedProduct.origin}</Description> 
<Description term="Catalog">{topRatedProduct.catalog==null?appLocaleName(userContext,"NotAssigned"):topRatedProduct.catalog.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Catalog","catalog",TopRatedProductService.requestCandidateCatalog,
	      TopRatedProductService.transferToAnotherCatalog,"anotherCatalogId",topRatedProduct.catalog?topRatedProduct.catalog.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Last Update Time">{ moment(topRatedProduct.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Profile">{topRatedProduct.profile==null?appLocaleName(userContext,"NotAssigned"):topRatedProduct.profile.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Profile","profile",TopRatedProductService.requestCandidateProfile,
	      TopRatedProductService.transferToAnotherProfile,"anotherProfileId",topRatedProduct.profile?topRatedProduct.profile.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(topRatedProduct,targetComponent)}
      </DescriptionList>
	)

}


class TopRatedProductDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'topRatedProduct'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName,  } = this.props.topRatedProduct
    if(!this.props.topRatedProduct.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Top Rated Product",cardsFor: "topRatedProduct",
    	cardsSource: this.props.topRatedProduct,returnURL,displayName,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
        <div>
        {settingListOf(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}
        {subListsOf(cardsData)} 
        {largeTextOf(cardsData.cardsSource)}
          
        </div>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  topRatedProduct: state._topRatedProduct,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(TopRatedProductDashboard))

