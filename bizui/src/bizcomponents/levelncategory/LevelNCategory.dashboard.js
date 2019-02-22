

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
import styles from './LevelNCategory.dashboard.less'
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


const imageList =(levelNCategory)=>{return [
	 ]}

const internalImageListOf = (levelNCategory) =>defaultImageListOf(levelNCategory,imageList)

const optionList =(levelNCategory)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalSettingListOf = (levelNCategory) =>defaultSettingListOf(levelNCategory, optionList)
const internalLargeTextOf = (levelNCategory) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (levelNCategory,targetComponent) =>{
	
	
	const {LevelNCategoryService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{levelNCategory.id}</Description> 
<Description term="Parent Category">{levelNCategory.parentCategory==null?appLocaleName(userContext,"NotAssigned"):levelNCategory.parentCategory.displayName}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"Parent Category","levelTwoCategory",LevelNCategoryService.requestCandidateParentCategory,
	      LevelNCategoryService.transferToAnotherParentCategory,"anotherParentCategoryId",levelNCategory.parentCategory?levelNCategory.parentCategory.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="Name">{levelNCategory.name}</Description> 
	
        {buildTransferModal(levelNCategory,targetComponent)}
      </DescriptionList>
	)

}


class LevelNCategoryDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'levelNCategory'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, productListMetaInfo, newProductListMetaInfo, editorPickProductListMetaInfo, topRatedProductListMetaInfo, recommandProductListMetaInfo, productCount, newProductCount, editorPickProductCount, topRatedProductCount, recommandProductCount } = this.props.levelNCategory
    if(!this.props.levelNCategory.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Level N Category",cardsFor: "levelNCategory",
    	cardsSource: this.props.levelNCategory,returnURL,displayName,
  		subItems: [
{name: 'productList', displayName:'Product',type:'product',count:productCount,addFunction: true, role: 'product', metaInfo: productListMetaInfo},
{name: 'newProductList', displayName:'New Product',type:'newProduct',count:newProductCount,addFunction: true, role: 'newProduct', metaInfo: newProductListMetaInfo},
{name: 'editorPickProductList', displayName:'Editor Pick Product',type:'editorPickProduct',count:editorPickProductCount,addFunction: true, role: 'editorPickProduct', metaInfo: editorPickProductListMetaInfo},
{name: 'topRatedProductList', displayName:'Top Rated Product',type:'topRatedProduct',count:topRatedProductCount,addFunction: true, role: 'topRatedProduct', metaInfo: topRatedProductListMetaInfo},
{name: 'recommandProductList', displayName:'Recommand Product',type:'recommandProduct',count:recommandProductCount,addFunction: true, role: 'recommandProduct', metaInfo: recommandProductListMetaInfo},
    
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
  levelNCategory: state._levelNCategory,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(LevelNCategoryDashboard))

