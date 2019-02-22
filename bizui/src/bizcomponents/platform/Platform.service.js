import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addSite = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addSite/platformId/name/introduction/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSite = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateSiteProperties/platformId/id/name/introduction/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSiteList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeSiteList/platformId/siteIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addCatalog/platformId/name/sellerId/siteId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCatalog = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateCatalogProperties/platformId/id/name/sellerId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCatalogList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeCatalogList/platformId/catalogIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addBrand = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addBrand/platformId/brandName/logo/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBrand = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateBrandProperties/platformId/id/brandName/logo/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBrandList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeBrandList/platformId/brandIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addProduct/platformId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateProductProperties/platformId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeProductList/platformId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addBanner = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addBanner/platformId/name/imagePath/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBanner = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateBannerProperties/platformId/id/name/imagePath/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBannerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeBannerList/platformId/bannerIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addProfile/platformId/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateProfileProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProfileList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeProfileList/platformId/profileIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addUserAlert/platformId/message/profileId/location/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateUserAlertProperties/platformId/id/message/location/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAlertList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeUserAlertList/platformId/userAlertIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addNewProduct/platformId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/profileId/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNewProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateNewProductProperties/platformId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNewProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeNewProductList/platformId/newProductIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addEditorPickProduct/platformId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/profileId/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEditorPickProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateEditorPickProductProperties/platformId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEditorPickProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeEditorPickProductList/platformId/editorPickProductIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTopRatedProduct/platformId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/profileId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTopRatedProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTopRatedProductProperties/platformId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTopRatedProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTopRatedProductList/platformId/topRatedProductIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addRecommandProduct/platformId/name/parentCategoryId/brandId/productCoverImage/origin/catalogId/remark/profileId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRecommandProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateRecommandProductProperties/platformId/id/name/productCoverImage/origin/remark/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRecommandProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeRecommandProductList/platformId/recommandProductIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addSite,
  addCatalog,
  addBrand,
  addProduct,
  addBanner,
  addProfile,
  addUserAlert,
  addNewProduct,
  addEditorPickProduct,
  addTopRatedProduct,
  addRecommandProduct,
  updateSite,
  updateCatalog,
  updateBrand,
  updateProduct,
  updateBanner,
  updateProfile,
  updateUserAlert,
  updateNewProduct,
  updateEditorPickProduct,
  updateTopRatedProduct,
  updateRecommandProduct,
  removeSiteList,
  removeCatalogList,
  removeBrandList,
  removeProductList,
  removeBannerList,
  removeProfileList,
  removeUserAlertList,
  removeNewProductList,
  removeEditorPickProductList,
  removeTopRatedProductList,
  removeRecommandProductList }
export default PlatformService

